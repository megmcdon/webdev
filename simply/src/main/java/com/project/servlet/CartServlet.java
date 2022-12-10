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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.mail.MessagingException;

/**
 * Servlet implementation class Checkout RENAMED TO /cart!!!!
 */
@Controller
@RequestMapping("/cart")
//TODO: Rename to CartController
public class CartServlet {

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

        return "checkout";
   
    }

    @PostMapping( "/confirm" )
    public String confirm( Authentication auth, Model model )
    {
        String authEmail = auth.getName();

        Optional<UserEntity> oUser = db.findUserByEmail( authEmail );
        if( oUser.isPresent() )
        {
            UserEntity user = oUser.get();
            try
            {
                MailUtilGmail.sendMail( user.getEmail(), "test@gmail.com", "Simply Coffee - Confirm Order", "", true );
            }
            catch( Exception ex )
            {
                ex.printStackTrace();
            }
            model.addAttribute( "user", user );

            final List<CartEntity> cart = db.getCart( authEmail );
            model.addAttribute( "cart", cart );

            double totalPrice = 0;
            for( CartEntity o : cart )
            {
                totalPrice = totalPrice + ( o.getQuantity() * o.getProduct().getPrice() );
            }
            model.addAttribute( "totalPrice", totalPrice );

            return "confirmation";
        }
        return "login";
    }
}
