package br.com.zup.autores

import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Delete
import io.micronaut.http.annotation.PathVariable

@Controller("/autor")
class DeletaAutorController (private val autorRepository: AutorRepository) {

    @Delete("/{autorId}")
    fun deleta(@PathVariable autorId: Long) : HttpResponse<Any>{
        if (!autorRepository.existsById(autorId)) return HttpResponse.notFound()

        autorRepository.deleteById(autorId)
        return HttpResponse.ok()
    }
}