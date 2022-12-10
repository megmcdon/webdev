package com.project.dbservice;

import java.util.ArrayList;
import java.util.Optional;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.entity.CartEntity;
import com.project.entity.ProductEntity;
import com.project.entity.UserEntity;
import com.project.entity.OrdersEntity;

import com.project.repo.CartRepo;
import com.project.repo.ProductRepo;
import com.project.repo.UserRepo;
import com.project.repo.OrderRepo;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.project.email.*;

@Service
public class DBAccessService {
    private static final String CHECKOUT_CART = "checkout-cart";
    private static final String ADD_PRODUCTS = "add-products";

    @Autowired
    CartRepo cRepo;
    @Autowired
    UserRepo uRepo;
    @Autowired
    ProductRepo pRepo;
    @Autowired 
    OrderRepo oRepo;

    @Deprecated
    public Optional<UserEntity> login(String email, String password) {
        return uRepo.findByEmailAndPassword(email, password);
    }

    public boolean signUp(UserEntity user) {
        //todo make email unique
        //handle exception in controller
        if (uRepo.findByEmail(user.getEmail()).isPresent()) {
            return false;
        }
        uRepo.saveAndFlush(user);
        return true;
    }

    public List<CartEntity> getCart(int uid) {
        return cRepo.findByUserId(uid);
    }

    @Query(value = "select u from UserEntity as u where lower(u.email) = lower(:email)")
    public Optional<UserEntity> findUserByEmail(@Param("email") String email) {
        return uRepo.findByEmail(email);
    }

    public List<CartEntity> getCart(String email) {
        Optional<UserEntity> oUser = uRepo.findByEmail(email);
        if (oUser.isPresent()) {
            UserEntity user = oUser.get();
            return getCart(user.getId());
        } else {
            throw new RuntimeException("User not found");
        }
    }

    public boolean addToCart( CartEntity newEntity, String uri )
    {
        ProductEntity product = newEntity.getProduct();
        UserEntity user = newEntity.getUser();

        Optional<CartEntity> cartRecord = cRepo.findByUserIdAndProductId( user.getId(), product.getId() );
        if( cartRecord.isPresent() )
        {
            CartEntity previousEntity = cartRecord.get();

            int newQuantity = 0;
            if( CHECKOUT_CART.equalsIgnoreCase( uri ) )
            {
                newQuantity = newEntity.getQuantity();
            }
            else if( ADD_PRODUCTS.equalsIgnoreCase( uri ) )
            {
                newQuantity = previousEntity.getQuantity() + newEntity.getQuantity();
            }

            if( product.getStock() - newQuantity < 0 )
            {
                return false;
            }
            previousEntity.setQuantity( newQuantity );
            cRepo.saveAndFlush( previousEntity );
            return true;
        }

        if( product.getStock() - newEntity.getQuantity() < 0 )
        {
            return false;
        }
        cRepo.saveAndFlush( newEntity );
        return true;
    }

    public ArrayList<ProductEntity> getAllProducts() {
        return (ArrayList<ProductEntity>) pRepo.findAll();
    }


	public ArrayList<ProductEntity> getProductCategory(String category){
		return (ArrayList<ProductEntity>) pRepo.findByCategory(category);
	}
	
	public ProductEntity getProduct(int pid) {
		return pRepo.findById(pid);
	}
	
	public ArrayList<OrdersEntity> getOrders(int uid){
		return (ArrayList<OrdersEntity>) oRepo.findByUid(uid);
	}
	
	/*
	//structure of the entity changed here!!!!
	public boolean validateOrder(ArrayList<CartEntity> cart) {
		//check that stock is available
		for(int x=0; x<cart.size(); x+=1) {
			if(pRepo.findById(cart.get(x).getPid()).getStock()-cart.get(x).getQuantity()<0) {
				return false;
			}
		}
		return true;
	}
	
	/*
	//structure of the entity changed here!!!!
	public OrdersEntity confirmOrder(ArrayList<CartEntity> cart, int uid) {
		//update stock and caclulate total
				double orderTotal=0;
				for(int x=0; x<cart.size(); x+=1) {
					orderTotal+=cart.get(x).getQuantity()*pRepo.findById(cart.get(x).getPid()).getPrice();
					int newStock=pRepo.findById(cart.get(x).getPid()).getStock()-cart.get(x).getQuantity();
					ProductEntity update = pRepo.findById(cart.get(x).getPid());
					update.setStock(newStock);
					pRepo.saveAndFlush(update);
				}
				//save order to database
				OrdersEntity newOrder = new OrdersEntity();
				newOrder.setTotal(orderTotal);
				newOrder.setUid(uid);
				oRepo.saveAndFlush(newOrder);
				return newOrder;
	}
	*/
	
	public String formatTotal(double total) {
		return String.format("$%,.2f", total);
	}
	
	public String sendEmail(String to, String name,double total,int OrderId, String itemsHTML) {

		
        String from = "682.81.fa22.mmcdon39@gmail.com";
        String subject = "Simply Coffee Order Confirmation: Order #"+OrderId;

        String body = "<html>\n"
        		+ "<head>\n"
        		+ "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n"
        		+ "<title>"+subject+"</title>\n"
        		+ "</head>\n"
        		+ "<body>\n"
        		+ "	<h1>Thank you for ordering with us!</h1>\n"
        		+ "Hello, <b>"
        		+ name
        		+ "!	</b>\n"
        		+ "	<br>\n"
        		+ "	<br> Thank you for placing an order with us. Your total is\n"
        		+ formatTotal(total)
        		+ "	<br>\n"
        		+ "</b> below are the items included in your order:\n"
        		+  itemsHTML
        		+ "	<br>\n"
        		+ "</b> Thank you for shopping with us!\n"
        		+ "	<br>\n"
        		+ "</body>\n"
        		+ "</html>";
        
        
        
        boolean isBodyHTML = true;

        try {
            //MailUtilLocal.sendMail(to, from, subject, body, isBodyHTML);
            MailUtilGmail.sendMail(to, from, subject, body, isBodyHTML);
            return "email sent successfully";
        } catch (MessagingException e) {
            System.out.println(
                    "Unable to send email. \n"
                    + "Here is the email you tried to send: \n"
                    + "=====================================\n"
                    + "TO: " + to + "\n"
                    + "FROM: " + from + "\n"
                    + "SUBJECT: " + subject + "\n"
                    + "\n"
                    + body + "\n\n");
        	return "email sent unsuccessfully";
        }
        
	}
	
	public boolean updateStock(int pid, int stock) {
		ProductEntity update = pRepo.findById(pid);
		if(stock>=0) {
			update.setStock(stock);
			pRepo.saveAndFlush(update);
			return true;
		}
		else {
			return false;
		}
		
	}


}
