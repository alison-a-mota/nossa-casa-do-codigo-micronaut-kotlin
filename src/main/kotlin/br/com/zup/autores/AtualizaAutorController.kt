package br.com.zup.autores

import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.PathVariable
import io.micronaut.http.annotation.Put
import javax.transaction.Transactional

@Controller("/autor")
open class AtualizaAutorController(private val autorRepository: AutorRepository) {

    @Put("/{autorId}")
    @Transactional
    open fun atualizaDescricao(
        @PathVariable autorId: Long,
        descricao: String,
        email: String,
        nome: String
    ): HttpResponse<Any> {
        val possivelAutor = autorRepository.findById(autorId)
        if (possivelAutor.isEmpty) return HttpResponse.notFound()

        val autor = possivelAutor.get()
        autor.descricao = descricao
        autor.email = email
        autor.nome = nome

        return HttpResponse.ok()

    }
}