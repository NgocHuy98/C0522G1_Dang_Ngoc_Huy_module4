package com.example.cart.controller;

import com.example.cart.dto.CartDto;
import com.example.cart.dto.ProductDto;
import com.example.cart.model.Product;
import com.example.cart.service.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@Controller
@SessionAttributes("cart")
@RequestMapping("/product")
public class ProductController {

    @ModelAttribute("cart")
    public CartDto innitCard(){
        return new CartDto();
    }

    @Autowired
    private IProductService iProductService;

    @GetMapping()
    public String showList(@PageableDefault(value = 3) Pageable pageable,
                           @RequestParam(defaultValue = "") String search,
                           @CookieValue(value = "product", defaultValue = "-1") int idProduct,
                           Model model) {
        if (idProduct != -1) {
            model.addAttribute("history", iProductService.findById(idProduct).get());
        }
        model.addAttribute("product", iProductService.findByNameContaining(search, pageable));

        return "index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("product", new Product());

        return "create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Product product, RedirectAttributes redirectAttributes) {
        iProductService.save(product);
        redirectAttributes.addFlashAttribute("message", "Create new product successfully!");
        return "redirect:/product";
    }

    @GetMapping("detail/{id}")
    public ModelAndView showDetail(@PathVariable int id, HttpServletResponse response){
        Cookie cookie = new Cookie("idProduct",id + "");
        cookie.setMaxAge(60*60*24);
        cookie.setPath("/");
        response.addCookie(cookie);
        return   new ModelAndView("create","product",iProductService.findById(id).get());

    }

    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable int id,
                            @SessionAttribute("cart")CartDto cart){
        Optional<Product> productDetail = iProductService.findById(id);
        if(productDetail.isPresent()){
            ProductDto productDto = new ProductDto();
            BeanUtils.copyProperties(productDetail.get(), productDto);
            cart.addProduct(productDto);
        }
        return "redirect:/cart";
    }

    @GetMapping("/delete/{id}")
    public String deleteCart(@PathVariable int id,
                            @SessionAttribute("cart")CartDto cart){
        Optional<Product> productDetail = iProductService.findById(id);

            ProductDto productDto = new ProductDto();
            BeanUtils.copyProperties(productDetail.get(), productDto);
            cart.deleteCart(productDto);
        return "redirect:/cart";
    }


}
