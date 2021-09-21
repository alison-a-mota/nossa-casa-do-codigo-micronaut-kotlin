package br.com.zup.autores

import javax.persistence.Embeddable

@Embeddable
class Endereco(
    enderecoResponse: EnderecoResponse,
    val numero: String, cep: String
) {
    val rua = enderecoResponse.logradouro
    val bairro = enderecoResponse.bairro
    val cidade = enderecoResponse.localidade
    val estado = enderecoResponse.uf

}
