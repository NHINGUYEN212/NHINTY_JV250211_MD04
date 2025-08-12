package ra.com.exercise03and04.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ra.com.exercise03and04.model.Product;
import ra.com.exercise03and04.service.ProductService;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;
    @GetMapping
    public String getProducts(Model model, @RequestParam(required = false, name = "searchProductName") String searchProductName) {
        List<Product> products = productService.searchProductsByName(searchProductName);
        model.addAttribute("products", products);
        model.addAttribute("searchProductName", searchProductName);
        return "products";
    }
}
