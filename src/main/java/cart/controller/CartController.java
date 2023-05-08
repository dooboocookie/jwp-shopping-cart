package cart.controller;

import cart.controller.auth.argumentresolver.AuthorizationUserInfo;
import cart.controller.auth.dto.LoginUser;
import cart.controller.dto.CartResponse;
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

    @PostMapping
    public ResponseEntity<Void> createCart(@AuthorizationUserInfo final LoginUser loginUser, @RequestParam final Long itemId) {
        cartService.saveCart(loginUser.getEmail(), itemId);
        return ResponseEntity.status(HttpStatus.CREATED)
                .location(URI.create("/"))
                .build();
    }

    @GetMapping
    public ResponseEntity<List<CartResponse>> readCart(@AuthorizationUserInfo LoginUser loginUser) {
        List<CartResponse> carts = cartService.loadItemInsideCart(loginUser.getEmail());
        return ResponseEntity.status(HttpStatus.OK)
                .body(carts);
    }

    @DeleteMapping("/{cartId}")
    public ResponseEntity<Void> deleteCart(@AuthorizationUserInfo final LoginUser loginUser, @PathVariable final Long cartId) {
        cartService.deleteCart(loginUser.getEmail(), cartId);
        return ResponseEntity.status(HttpStatus.OK)
                .location(URI.create("/"))
                .build();
    }
}
