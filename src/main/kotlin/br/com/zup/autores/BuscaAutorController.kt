package br.com.zup.autores

import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.QueryValue
import java.util.*
import javax.transaction.Transactional

@Controller("/autor")
open class BuscaAutorController(private val autorRepository: AutorRepository) {

    @Get
    @Transactional
    open fun lista(@QueryValue(defaultValue = "") email: String) : HttpResponse<Any> {

        if(email.isBlank()) {
            val resposta = autorRepository.findAll().map { autor -> DetalhesAutorResponse(autor) }
            return HttpResponse.ok(resposta)
        }

        val possivelAutor: Optional<Autor> = autorRepository.buscaPorEmail(email)
        if(possivelAutor.isEmpty) return HttpResponse.notFound()

        val autor = possivelAutor.get()
        return HttpResponse.ok(DetalhesAutorResponse(autor))
    }
}