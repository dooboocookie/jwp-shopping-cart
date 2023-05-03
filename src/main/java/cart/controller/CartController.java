package cart.controller;

import cart.controller.dto.ItemResponse;
import cart.controller.dto.LoginUser;
import cart.service.CartService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/carts")
public class CartController {

    private final CartService cartService;

    public CartController(final CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping("/{itemId}")
    public ResponseEntity<Void> createCart(@BasicAuthorization final LoginUser loginUser, @PathVariable final Long itemId) {
        cartService.saveCart(loginUser.getEmail(), itemId);
        return ResponseEntity.status(HttpStatus.CREATED)
                .location(URI.create("/"))
                .build();
    }

    @GetMapping
    public ResponseEntity<List<ItemResponse>> readCart(@BasicAuthorization LoginUser loginUser) {
        List<ItemResponse> items = cartService.loadItemInsideCart(loginUser.getEmail());
        return ResponseEntity.status(HttpStatus.OK)
                .body(items);
    }
}