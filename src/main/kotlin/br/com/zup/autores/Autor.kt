package br.com.zup.autores

import java.time.LocalDateTime
import javax.persistence.*
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

@Entity
class Autor (
    @field:NotBlank var nome: String,
    @field:NotBlank @field:Email var email: String,
    @field:NotBlank @field:Size(max = 400) var descricao: String,
    @Embedded val endereco: Endereco
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
    val criadoEm: LocalDateTime = LocalDateTime.now()
}
