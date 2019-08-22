package com.mercadolibre.itacademy.grails

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*
import grails.rest.RestfulController

class ArticuloController extends RestfulController<Articulo>{

    static responseFormats = ['json']
    ArticuloController(){
        super(Articulo)
    }
    @Override
    def index() {
        def marcaId = params.marcaId
        if(marcaId != null) {
            respond Articulo.where {
                marca.id == marcaId
            }.list()
        } else {
            respond Articulo.list()
        }
    }


}
