package com.project.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;

import com.project.dbservice.DBAccessService;
import com.project.entity.ProductEntity;
import java.util.List;
import java.util.Optional;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/products")
//TODO: Rename to product controller
public class ProductServlet {
    private static final String IS_ADMIN_AUTH = "isAdminAuth";
    private static final String IS_NORMAL_AUTH = "isAuth";

    @Autowired
    private DBAccessService db;

    /**
     * LOOKS FOR PARAMETERS category OR p_id and RETURNS ACCORDINGLY REDIRECT
     * WITH category OR NO PARAMETERS IS TO /products.jsp WITH REQUEST ATTRIBUTE
     * products REDIRECT WITH p_id IS TO /product.jsp WITH REQUEST ATTRIBUTE
     * product
     *
     * @param category
     * @param model
     * @return
     */
    @GetMapping
    public String listProducts(@RequestParam(name = "category", required = false, defaultValue = "") String category, Model model, Authentication auth) {
        //only allow permitted categories
        if (!category.isEmpty() && category.toLowerCase().matches("brew|merch|beans")) {
            List<ProductEntity> productList = db.getProductCategory(category);
            model.addAttribute(category, productList);
            model.addAttribute("cat", category);
        } else {
            //NB: streams can be used to filter list into a map
            List<ProductEntity> brew = db.getProductCategory("brew");
            model.addAttribute("brew", brew);
            List<ProductEntity> merch = db.getProductCategory("merch");
            model.addAttribute("merch", merch);
            List<ProductEntity> beans = db.getProductCategory("beans");
            model.addAttribute("beans", beans);
            model.addAttribute("cat", "All");
        }
        setAuthParameters( model, auth );
        return "products";

    }

    @GetMapping("/{id}")
    public String viewProduct(@PathVariable("id") Integer p_id, Model model, Authentication auth) {
        ProductEntity product = db.getProduct(p_id);
        //TODO: if product is null show 404
        model.addAttribute("product", product);
        setAuthParameters( model, auth );
        return "product";

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //TODO use this to let admin alter products

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
