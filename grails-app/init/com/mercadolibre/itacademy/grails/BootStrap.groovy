package com.mercadolibre.itacademy.grails

import grails.converters.JSON

import java.text.SimpleDateFormat

class BootStrap {

    def init = { servletContext ->
        def marca1 = new Marca(name:"Adidas").save(flush:true)
        def marca2 = new Marca(name:"Nike").save(flush:true)
        def marca3 = new Marca(name:"Rebook").save(flush:true)
        def marca4 = new Marca(name:"Puma").save(flush:true)
        def marca5 = new Marca(name:"Mike").save(flush:true)

        marca1.addToArticulo(new Articulo(name:"Zapatillas 1", picture:"http://lorempixel.com/200/200",total_items_in_this_category: 2)).save()
        marca1.addToArticulo(new Articulo(name:"Botines 1", picture:"http://lorempixel.com/200/200",total_items_in_this_category: 2)).save()
        marca2.addToArticulo(new Articulo(name:"Zapatillas 2", picture:"http://lorempixel.com/200/200",total_items_in_this_category: 2)).save()
        marca2.addToArticulo(new Articulo(name:"Botines 2", picture:"http://lorempixel.com/200/200",total_items_in_this_category: 2)).save()
        marca3.addToArticulo(new Articulo(name:"Camiseta 1", picture:"http://lorempixel.com/200/200",total_items_in_this_category: 2)).save()
        marca3.addToArticulo(new Articulo(name:"Lompa 1", picture:"http://lorempixel.com/200/200",total_items_in_this_category: 2)).save()
        marca4.addToArticulo(new Articulo(name:"Camiseta 2", picture:"http://lorempixel.com/200/200",total_items_in_this_category: 2)).save()
        marca4.addToArticulo(new Articulo(name:"Lompa 2", picture:"http://lorempixel.com/200/200",total_items_in_this_category: 2)).save()
        marca5.addToArticulo(new Articulo(name:"Campera 1", picture:"http://lorempixel.com/200/200",total_items_in_this_category: 2)).save()
        marca5.addToArticulo(new Articulo(name:"Medias 1", picture:"http://lorempixel.com/200/200",total_items_in_this_category: 2)).save()



        marshaler()
    }
    def destroy = {
    }

    private void marshaler(){
        JSON.registerObjectMarshaller(Articulo){
            articulo -> [
                    id: articulo.id,
                    name: articulo.name,
                    picture: articulo.picture,
                    total_items_in_this_category: articulo.total_items_in_this_category,
                    children_categories: []
            ]
        }

    }



    /*
    private void marshaler(){
        JSON.registerObjectMarshaller(Hotel){
            hotel -> [
                    id: hotel.id,
                    name: hotel.name,
                    rooms: hotel.rooms.collect {
                        room -> [
                                id: room.id,
                                number: room.number
                        ]
                    }
            ]
        }
        JSON.registerObjectMarshaller(Room){
            room -> [
                    id: room.id,
                    number: room.number,
                    date: new SimpleDateFormat("dd/MM/yyyy").format(new Date())
            ]
        }

    }
    */

}
