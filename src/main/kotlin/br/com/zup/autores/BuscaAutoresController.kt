package br.com.zup.autores

import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get

@Controller("/autor")
class BuscaAutoresController(val autorRepository: AutorRepository) {

    @Get
    fun lista() : HttpResponse<List<DetalhesAutorResponse>> {

        val listaDeAutores = autorRepository.findAll()
        val resposta = listaDeAutores.map{ autor -> DetalhesAutorResponse(autor)}

        return HttpResponse.ok(resposta)

    }
}