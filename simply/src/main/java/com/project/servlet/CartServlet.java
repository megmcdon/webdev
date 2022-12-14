package com.project.servlet;

import com.project.email.MailUtilGmail;
import org.springframework.beans.factory.annotation.Autowired;

import com.project.dbservice.DBAccessService;
import com.project.entity.CartEntity;
import com.project.entity.UserEntity;
import java.util.List;
import java.util.Optional;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.mail.MessagingException;

/**
 * Servlet implementation class Checkout RENAMED TO /cart!!!!
 */
@Controller
@RequestMapping("/cart")
//TODO: Rename to CartController
public class CartServlet {
    private static final String IS_ADMIN_AUTH = "isAdminAuth";
    private static final String IS_NORMAL_AUTH = "isAuth";
    private static final long serialVersionUID = 1L;

    @Autowired
    private DBAccessService db;

    /**
     * GETS CART AND FORWARDS REQUEST ATTRIBUTE cart TO /cart.jsp IF USER NOT
     * LOGGED IN, FORWARD TO /login.jsp
     *
     * @param model
     * @param auth current authenticated user
     * @return
     */
    @GetMapping
    public String showCart(Model model, Authentication auth) {
        final List<CartEntity> cart = db.getCart(auth.getName());
        System.out.println("cart = " + cart.size());
//        HttpSession session = request.getSession(true);
//        UserEntity user = (UserEntity) session.getAttribute("user");
//        if (user == null) {
//            request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
//
//        } else {
        model.addAttribute("cart", cart);

        double totalPrice = 0;
        for( CartEntity o : cart )
        {
            totalPrice = totalPrice + ( o.getQuantity() * o.getProduct().getPrice() );
        }
        model.addAttribute( "totalPrice", totalPrice );

        setAuthParameters( model, auth );

        return "cart";
//            request.getRequestDispatcher("/WEB-INF/cart.jsp").forward(request, response);
//        }
    }

    /**
     * SAVES ITEM TO CART, TAKES REQUEST PARAMETERS p_id AND quantity REFUSES TO
     * ADD MORE QUANTITY TO CART THAN AVAILABLE STOCK
     *
     * @param auth
     * @param pid
     * @param quantity
     * @param ra
     * @return
     */
    @PostMapping
    public String addToCart( Authentication auth, @RequestParam( "pid" ) Integer pid, @RequestParam( "quantity" ) Integer quantity, @RequestParam( "uri" ) String uri, RedirectAttributes ra ) {
        String email = auth.getName();
        Optional<UserEntity> oUser = db.findUserByEmail(email);
        UserEntity user = oUser.get();
//        HttpSession session = request.getSession(true);
//        UserEntity user = (UserEntity) session.getAttribute("user");
//        if (user == null) {
//            request.getRequestDispatcher("/WEB-INF/signup.jsp").forward(request, response);
//
//        } else {
        CartEntity add = new CartEntity();
        add.setProduct(db.getProduct(pid));
        add.setQuantity(quantity);
        add.setUser(user);
        if( db.addToCart( add, uri ) ) {
            //TODO redirect client back to whatever page they were on
            ra.addFlashAttribute("msg", "Item Added");
        } else {
            //TODO redirect client and tell them there isn't enough stock 
            ra.addFlashAttribute("msg", "Item Out of Stock");
        }

//        }
        return "redirect:/cart";
    }

    /**
     * UPDATE ITEM STOCK
     *
     * @param pid   pid
     * @param stock stock
     * @return page
     */
    @PutMapping
    @RequestMapping( "/stock" )
    public String updateStock( @RequestParam( "pid" ) Integer pid, @RequestParam( "stock" ) Integer stock )
    {
        db.updateStock( pid, stock );
        return "redirect:/adminPortal";
    }

    @GetMapping
    @RequestMapping( "/checkout" )
    public String checkout( Authentication auth, Model model )
    {
        String authEmail = auth.getName();

        Optional<UserEntity> oUser = db.findUserByEmail( authEmail );
        if( oUser.isPresent() )
        {
            UserEntity user = oUser.get();
            model.addAttribute( "user", user );
        }

        final List<CartEntity> cart = db.getCart( authEmail );
        model.addAttribute( "cart", cart );

        double totalPrice = 0;
        for( CartEntity o : cart )
        {
            totalPrice = totalPrice + ( o.getQuantity() * o.getProduct().getPrice() );
        }
        model.addAttribute( "totalPrice", totalPrice );

        setAuthParameters( model, auth );

        return "checkout";
   
    }

    @PostMapping( "/confirm" )
    public String confirm( Authentication auth, Model model )
    {
        String authEmail = auth.getName();

        Optional<UserEntity> oUser = db.findUserByEmail( authEmail );
        if(!oUser.isPresent()) {
            model.addAttribute( IS_ADMIN_AUTH, false );
            model.addAttribute( IS_NORMAL_AUTH, false );
        	return "login";
        }
        else if( db.checkout(oUser.get().getId()))
        {
            UserEntity user = oUser.get();
            try
            {
            	model.addAttribute( "user", user );

                final List<CartEntity> cart = db.deleteCart(user.getId());
                model.addAttribute( "cart", cart );

                double totalPrice = 0;
                for( CartEntity o : cart )
                {
                    totalPrice = totalPrice + ( o.getQuantity() * o.getProduct().getPrice() );
                }
                model.addAttribute( "totalPrice", totalPrice );
                db.createOrder(user.getId(), cart, totalPrice);

            	String to = user.getEmail();
            	String from = "	Simply Coffee <682.81.fa22.mmcdon39@gmail.com>";
            	String subject="Simply Coffee - Order Confirmation";
            	
            	String itemList="";
            	for (int i=0; i <cart.size();i++) {
            		itemList=itemList+"<tr>\n"
            				+ "<th>"
            				+ cart.get(i).getProduct().getName()
            				+"</th>\n"
            				+ "<th>"
            				+ cart.get(i).getQuantity()
            				+"</th>\n"
            				+ "<th>"
            				+ cart.get(i).getProduct().getPrice()*cart.get(i).getQuantity()
            				+"</th>\n";
            	}
            	
            	            	
            	String body="<html>\n"
                		+ "<head>\n"
                		+ "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n"
                		+ "<title>"+subject+"</title>\n"
                		+ "</head>\n"
                		+ "<body>\n"
                		+ "	<h1>Simply Coffee thanks you for ordering with us!</h1>\n"
                		+ "Hello, <b>"
                		+ user.getFirstName()
                		+ "!</b>\n"
                		+ "	<br> <br>\n"
                		+ "Your total today is: <b>"
                		+ db.formatTotal(totalPrice)
                		+ "</b> <br> <br>"
                		+ "<table style=\"border: 1px solid black; margin-left: auto; margin-right: auto;\">"
                		+ "<tbody>\n"
                		+ "<tr>\n"
                		+ "<th>Item</th>\n"
                		+ "<th>Quantity</th>\n"
                		+ "<th>Price</th>\n"
                		+ "</tr>"
                		+ itemList
                		+ "</tbody>\n"
                		+ "	</table>"
                		+ "</body>\n"
                		+ "</html>";
            	
            	boolean isHTML=true;
            	
            	MailUtilGmail.sendMail(to, from, subject, body, isHTML);
            	
            	System.out.println("email sent successfully");
                
            }
            catch( MessagingException e )
            {
                e.printStackTrace();
            	
            }
            /*
            model.addAttribute( "user", user );

            final List<CartEntity> cart = db.getCart( authEmail );
            model.addAttribute( "cart", cart );

            double totalPrice = 0;
            for( CartEntity o : cart )
            {
                totalPrice = totalPrice + ( o.getQuantity() * o.getProduct().getPrice() );
            }
            model.addAttribute( "totalPrice", totalPrice );

             */

            if( oUser.get().isAdmin() )
            {
                model.addAttribute( IS_ADMIN_AUTH, true );
                model.addAttribute( IS_NORMAL_AUTH, false );
            }
            else
            {
                model.addAttribute( IS_ADMIN_AUTH, false );
                model.addAttribute( IS_NORMAL_AUTH, true );
            }

            return "confirmation";
            
            
        }
        else{
        	String cartError="Item quantity exceeds stock-- item removed.";
            model.addAttribute( "cartError", cartError );

        	return showCart(model, auth);
        }
        
       
    }

    private void setAuthParameters( Model model, Authentication auth )
    {
        if( auth == null )
        {
            model.addAttribute( IS_ADMIN_AUTH, false );
            model.addAttribute( IS_NORMAL_AUTH, false );
            return;
        }

        Optional<UserEntity> oUser = db.findUserByEmail( auth.getName() );
        if( !oUser.isPresent() )
        {
            model.addAttribute( IS_ADMIN_AUTH, false );
            model.addAttribute( IS_NORMAL_AUTH, false );
            return;
        }

        if( oUser.get().isAdmin() )
        {
            model.addAttribute( IS_ADMIN_AUTH, true );
            model.addAttribute( IS_NORMAL_AUTH, false );
            return;
        }
        model.addAttribute( IS_ADMIN_AUTH, false );
        model.addAttribute( IS_NORMAL_AUTH, true );
    }
}
