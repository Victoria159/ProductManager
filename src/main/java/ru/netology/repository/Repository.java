package ru.netology.repository;

import ru.netology.domain.Product;

public class Repository {
    private Product[] products = new Product[0];

    public void save(Product product) {
        int length = products.length + 1;
        Product[] tmp = new Product[length];
        System.arraycopy(products, 0, tmp, 0, products.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = product;
        products = tmp;
    }
    public Product[] findAll() {
        return products;
    }

    public Product findById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    public void removeById(int id) {
        if (findById(id) == null) {
            throw new NotFoundException("Element with id: " + id + " not found");
        }
        Product[] tmp2 = new Product[products.length - 1];
        int index = 0;
        for (Product product : products) {
            if (product.getId() != id) {
                tmp2[index] = product;
                index++;
            }
        }
        products = tmp2;

    }



//    public void removeById(int id) {
//        int length = products.length - 1;
//        Product[] tmp = new Product[length];
//        int index = 0;
//        for (Product product : products) {
//            if (product.getId() != id) {
//                tmp[index] = product;
//                index++;
//            }
//        }
//        products = tmp;
//    }


}
