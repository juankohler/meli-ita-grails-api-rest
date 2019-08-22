package com.mercadolibre.itacademy.grails

import grails.rest.Resource

@Resource(uri="/marcas")
class Marca {
    String id;
    String name;
    static hasMany = [articulo:Articulo]

    static constraints = {
    }
}
