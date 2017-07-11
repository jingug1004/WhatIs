package net.balgre.domain;

import lombok.Data;

import java.util.List;

@Data
public class WishListResponse {

    private String message;
    private String resultCode;
    private String timestamp;
    private List<Wishlist> wishList;


}
