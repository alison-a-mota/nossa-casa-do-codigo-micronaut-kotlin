package br.com.zup.autores

import io.micronaut.http.HttpResponse
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Consumes
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.PathVariable
import io.micronaut.http.annotation.Produces
import io.micronaut.http.client.annotation.Client

@Client("https://viacep.com.br/ws")
interface EnderecoClient {

    @Get("/{cep}/json/")
    fun consulta(@PathVariable cep: String):HttpResponse<EnderecoResponse>

    @Get(consumes = [ MediaType.APPLICATION_XML],
    produces = [ MediaType.APPLICATION_XML ])

    // dá pra fazer assim tbm \/
//    @Produces(MediaType.APPLICATION_XML)
//    @Consumes(MediaType.APPLICATION_XML)

    fun consultaViaXml(@PathVariable cep: String):HttpResponse<EnderecoResponse>

}