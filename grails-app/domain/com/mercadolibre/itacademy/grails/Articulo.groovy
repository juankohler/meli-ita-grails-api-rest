package com.mercadolibre.itacademy.grails

import grails.rest.Resource

@Resource(uri="/articulos")
class Articulo {
        String id
        String name
        String picture
        int total_items_in_this_category
        static belongsTo = [marca:Marca]

    static constraints = {

    }
}
