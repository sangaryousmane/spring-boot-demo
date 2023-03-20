package com.dailycodebuffer.springbootdemo.exceptions.backend;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ProductsNotFoundException extends RuntimeException{

    public ProductsNotFoundException(String message) {
        super(message);
    }


}
