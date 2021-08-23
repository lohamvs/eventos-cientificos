# eventos-cientificos

## Modelo de classes
- https://online.visual-paradigm.com/community/share/eventos-cientificos

## Documentação

h1. Eventos Cientificos Sistema para cadastrar anais de eventos científicos. 

*Version:* 1.0.0

----

{toc:printable=true|style=square|minLevel=2|maxLevel=3|type=list|outline=false|include=.*}

h2. Endpoints

    h3. atualizaArtigo
    {status:colour=Yellow|title=put|subtle=false}
    {code}
    put /volumes/{volumeId}/artigos/{artigoId}
    {code}
    *Summary:* Atualiza um artigo.
    *Description:* 


    h4. Parameters
        h5. Path Parameters
        ||Name||Description||Required||Default||Pattern||
        |volumeId |ID do volume que contém o artigo. |(/) | |  |

|artigoId |ID do artigo a ser atualizado. |(/) | |  |


        h5. Body Parameter
        ||Name||Description||Required||Default||Pattern||
        |body | |(/) | |  |







    h4. Responses
        *Status Code:* 200
        *Message:*     Operação executada com sucesso.
        {code:title=Response Type}
Artigo
        {code}
        See [#models]



        {code:title=Response Schema |collapse=true}
{
  "description" : "Operação executada com sucesso.",
  "schema" : {
    "$ref" : "#/definitions/Artigo"
  }
}
        {code}
        *Status Code:* 400
        *Message:*     Artigo inválido.
        {code:title=Response Type}

        {code}
        See [#models]



        {code:title=Response Schema |collapse=true}
{
  "description" : "Artigo inválido."
}
        {code}
    ----

    h3. buscaArtigoPorId
    {status:colour=Yellow|title=get|subtle=false}
    {code}
    get /volumes/{volumeId}/artigos/{artigoId}
    {code}
    *Summary:* Busca artigo por ID
    *Description:* Retorna um artigo.


    h4. Parameters
        h5. Path Parameters
        ||Name||Description||Required||Default||Pattern||
        |volumeId |ID do volume que contém o artigo. |(/) | |  |

|artigoId |ID do artigo a ser retornado. |(/) | |  |








    h4. Responses
        *Status Code:* 200
        *Message:*     Operação executada com sucesso.
        {code:title=Response Type}
Artigo
        {code}
        See [#models]



        {code:title=Response Schema |collapse=true}
{
  "description" : "Operação executada com sucesso.",
  "schema" : {
    "$ref" : "#/definitions/Artigo"
  }
}
        {code}
        *Status Code:* 400
        *Message:*     ID inválido.
        {code:title=Response Type}

        {code}
        See [#models]



        {code:title=Response Schema |collapse=true}
{
  "description" : "ID inválido."
}
        {code}
        *Status Code:* 404
        *Message:*     Artigo ou volume não encontrado.
        {code:title=Response Type}

        {code}
        See [#models]



        {code:title=Response Schema |collapse=true}
{
  "description" : "Artigo ou volume não encontrado."
}
        {code}
    ----

    h3. buscaTodosArtigos
    {status:colour=Yellow|title=get|subtle=false}
    {code}
    get /volumes/{volumeId}/artigos
    {code}
    *Summary:* Retorna todos os artigos de um volume.
    *Description:* 


    h4. Parameters
        h5. Path Parameters
        ||Name||Description||Required||Default||Pattern||
        |volumeId |ID do volume que contém os artigos. |(/) | |  |








    h4. Responses
        *Status Code:* 200
        *Message:*     Operação executada com sucesso.
        {code:title=Response Type}
map[String, Integer]
        {code}
        See [#models]



        {code:title=Response Schema |collapse=true}
{
  "description" : "Operação executada com sucesso.",
  "schema" : {
    "type" : "object",
    "additionalProperties" : {
      "type" : "integer",
      "format" : "int32"
    }
  }
}
        {code}
    ----

    h3. criaArtigo
    {status:colour=Yellow|title=post|subtle=false}
    {code}
    post /volumes/{volumeId}/artigos
    {code}
    *Summary:* Adiciona um novo artigo.
    *Description:* 


    h4. Parameters
        h5. Path Parameters
        ||Name||Description||Required||Default||Pattern||
        |volumeId |ID do volume que conterá o artigo. |(/) | |  |


        h5. Body Parameter
        ||Name||Description||Required||Default||Pattern||
        |body |Objeto de artigo a ser criado. |(/) | |  |







    h4. Responses
        *Status Code:* 405
        *Message:*     Entrada inválida
        {code:title=Response Type}

        {code}
        See [#models]



        {code:title=Response Schema |collapse=true}
{
  "description" : "Entrada inválida"
}
        {code}
    ----

    h3. deletaArtigo
    {status:colour=Yellow|title=delete|subtle=false}
    {code}
    delete /volumes/{volumeId}/artigos/{artigoId}
    {code}
    *Summary:* Deleta um artigo.
    *Description:* 


    h4. Parameters
        h5. Path Parameters
        ||Name||Description||Required||Default||Pattern||
        |volumeId |ID do volume que contém o artigo. |(/) | |  |

|artigoId |ID do artigo a ser deletade. |(/) | |  |


        h5. Body Parameter
        ||Name||Description||Required||Default||Pattern||
        |body | |(/) | |  |







    h4. Responses
        *Status Code:* 200
        *Message:*     Operação executada com sucesso.
        {code:title=Response Type}
Artigo
        {code}
        See [#models]



        {code:title=Response Schema |collapse=true}
{
  "description" : "Operação executada com sucesso.",
  "schema" : {
    "$ref" : "#/definitions/Artigo"
  }
}
        {code}
        *Status Code:* 400
        *Message:*     Artigo inválido.
        {code:title=Response Type}

        {code}
        See [#models]



        {code:title=Response Schema |collapse=true}
{
  "description" : "Artigo inválido."
}
        {code}
    ----

    h3. atualizaAutor
    {status:colour=Yellow|title=put|subtle=false}
    {code}
    put /autores/{autorId}
    {code}
    *Summary:* Atualiza um autor existente.
    *Description:* 


    h4. Parameters
        h5. Path Parameters
        ||Name||Description||Required||Default||Pattern||
        |autorId |ID do autor a ser atualizado. |(/) | |  |


        h5. Body Parameter
        ||Name||Description||Required||Default||Pattern||
        |body |Objeto de Autor a ser atualizado. |(/) | |  |







    h4. Responses
        *Status Code:* 404
        *Message:*     Autor não encontrado
        {code:title=Response Type}

        {code}
        See [#models]



        {code:title=Response Schema |collapse=true}
{
  "description" : "Autor não encontrado"
}
        {code}
    ----

    h3. buscaAutorPorId
    {status:colour=Yellow|title=get|subtle=false}
    {code}
    get /autores/{autorId}
    {code}
    *Summary:* Busca autor por ID
    *Description:* Retorna um autor.


    h4. Parameters
        h5. Path Parameters
        ||Name||Description||Required||Default||Pattern||
        |autorId |ID do autor a ser retornado. |(/) | |  |








    h4. Responses
        *Status Code:* 200
        *Message:*     Operação executada com sucesso.
        {code:title=Response Type}
Autor
        {code}
        See [#models]



        {code:title=Response Schema |collapse=true}
{
  "description" : "Operação executada com sucesso.",
  "schema" : {
    "$ref" : "#/definitions/Autor"
  }
}
        {code}
        *Status Code:* 400
        *Message:*     ID inválido
        {code:title=Response Type}

        {code}
        See [#models]



        {code:title=Response Schema |collapse=true}
{
  "description" : "ID inválido"
}
        {code}
        *Status Code:* 404
        *Message:*     Autor não encontrado.
        {code:title=Response Type}

        {code}
        See [#models]



        {code:title=Response Schema |collapse=true}
{
  "description" : "Autor não encontrado."
}
        {code}
    ----

    h3. buscaTodosAutoresPorVolume
    {status:colour=Yellow|title=get|subtle=false}
    {code}
    get /autores
    {code}
    *Summary:* Busca todos os autores de artigos.
    *Description:* 


    h4. Parameters



        h5. Query Parameters
        ||Name||Description||Required||Default||Pattern||
        |volumeId |ID do volume que contém os autores dos artigos. |(x) | |  |





    h4. Responses
        *Status Code:* 200
        *Message:*     Operação executada com sucesso.
        {code:title=Response Type}
array[Volume]
        {code}
        See [#models]



        {code:title=Response Schema |collapse=true}
{
  "description" : "Operação executada com sucesso.",
  "schema" : {
    "type" : "array",
    "items" : {
      "$ref" : "#/definitions/Volume"
    }
  }
}
        {code}
    ----

    h3. criaAutor
    {status:colour=Yellow|title=post|subtle=false}
    {code}
    post /autores
    {code}
    *Summary:* Adiciona um novo autor.
    *Description:* 


    h4. Parameters

        h5. Body Parameter
        ||Name||Description||Required||Default||Pattern||
        |body |Objeto de autor a ser criado. |(/) | |  |







    h4. Responses
        *Status Code:* 405
        *Message:*     Entrada inválida.
        {code:title=Response Type}

        {code}
        See [#models]



        {code:title=Response Schema |collapse=true}
{
  "description" : "Entrada inválida."
}
        {code}
    ----

    h3. deletaAutor
    {status:colour=Yellow|title=delete|subtle=false}
    {code}
    delete /autores/{autorId}
    {code}
    *Summary:* Deleta um autor.
    *Description:* 


    h4. Parameters
        h5. Path Parameters
        ||Name||Description||Required||Default||Pattern||
        |autorId |ID do autor a ser deletado |(/) | |  |








    h4. Responses
        *Status Code:* 400
        *Message:*     ID inválido
        {code:title=Response Type}

        {code}
        See [#models]



        {code:title=Response Schema |collapse=true}
{
  "description" : "ID inválido"
}
        {code}
        *Status Code:* 404
        *Message:*     Autor não encontrado.
        {code:title=Response Type}

        {code}
        See [#models]



        {code:title=Response Schema |collapse=true}
{
  "description" : "Autor não encontrado."
}
        {code}
    ----

    h3. atualizaVolume
    {status:colour=Yellow|title=put|subtle=false}
    {code}
    put /volumes/{volumeId}
    {code}
    *Summary:* Atualiza um volume existente.
    *Description:* 


    h4. Parameters
        h5. Path Parameters
        ||Name||Description||Required||Default||Pattern||
        |volumeId |ID do volume a ser retornado. |(/) | |  |


        h5. Body Parameter
        ||Name||Description||Required||Default||Pattern||
        |body |Objeto de Volume a ser atualizado. |(/) | |  |







    h4. Responses
        *Status Code:* 404
        *Message:*     Volume não encontrado.
        {code:title=Response Type}

        {code}
        See [#models]



        {code:title=Response Schema |collapse=true}
{
  "description" : "Volume não encontrado."
}
        {code}
    ----

    h3. buscaTodosVolumes
    {status:colour=Yellow|title=get|subtle=false}
    {code}
    get /volumes
    {code}
    *Summary:* Busca todos os volumes.
    *Description:* 


    h4. Parameters







    h4. Responses
        *Status Code:* 200
        *Message:*     Operação executada com sucesso.
        {code:title=Response Type}
array[Volume]
        {code}
        See [#models]



        {code:title=Response Schema |collapse=true}
{
  "description" : "Operação executada com sucesso.",
  "schema" : {
    "type" : "array",
    "items" : {
      "$ref" : "#/definitions/Volume"
    }
  }
}
        {code}
    ----

    h3. buscaVolumePorId
    {status:colour=Yellow|title=get|subtle=false}
    {code}
    get /volumes/{volumeId}
    {code}
    *Summary:* Busca volume por ID
    *Description:* Retorna um volume.


    h4. Parameters
        h5. Path Parameters
        ||Name||Description||Required||Default||Pattern||
        |volumeId |ID do volume a ser retornado. |(/) | |  |








    h4. Responses
        *Status Code:* 200
        *Message:*     Operação executada com sucesso.
        {code:title=Response Type}
Volume
        {code}
        See [#models]



        {code:title=Response Schema |collapse=true}
{
  "description" : "Operação executada com sucesso.",
  "schema" : {
    "$ref" : "#/definitions/Volume"
  }
}
        {code}
        *Status Code:* 400
        *Message:*     ID inválido
        {code:title=Response Type}

        {code}
        See [#models]



        {code:title=Response Schema |collapse=true}
{
  "description" : "ID inválido"
}
        {code}
        *Status Code:* 404
        *Message:*     Volume não encontrado.
        {code:title=Response Type}

        {code}
        See [#models]



        {code:title=Response Schema |collapse=true}
{
  "description" : "Volume não encontrado."
}
        {code}
    ----

    h3. criaVolume
    {status:colour=Yellow|title=post|subtle=false}
    {code}
    post /volumes
    {code}
    *Summary:* Adiciona um novo volume.
    *Description:* 


    h4. Parameters

        h5. Body Parameter
        ||Name||Description||Required||Default||Pattern||
        |body |Objeto de volume a ser criado. |(/) | |  |







    h4. Responses
        *Status Code:* 405
        *Message:*     Entrada inválida
        {code:title=Response Type}

        {code}
        See [#models]



        {code:title=Response Schema |collapse=true}
{
  "description" : "Entrada inválida"
}
        {code}
    ----

    h3. deletaVoluma
    {status:colour=Yellow|title=delete|subtle=false}
    {code}
    delete /volumes/{volumeId}
    {code}
    *Summary:* Deleta um volume.
    *Description:* 


    h4. Parameters
        h5. Path Parameters
        ||Name||Description||Required||Default||Pattern||
        |volumeId |ID do volume a ser deletado. |(/) | |  |








    h4. Responses
        *Status Code:* 400
        *Message:*     ID inválido.
        {code:title=Response Type}

        {code}
        See [#models]



        {code:title=Response Schema |collapse=true}
{
  "description" : "ID inválido."
}
        {code}
        *Status Code:* 404
        *Message:*     Volume não encontrado.
        {code:title=Response Type}

        {code}
        See [#models]



        {code:title=Response Schema |collapse=true}
{
  "description" : "Volume não encontrado."
}
        {code}
    ----

h2. Models

        h3. Artigo
        ||Field Name||Required||Type||Description||
         |id | |Long | |
 |ordem | |Long | |
 |idioma | |String | |
 |tituloOriginal | |String | |
 |tituloIngles | |String | |
 |resumoOriginal | |String | |
 |resumoIngles | |String | |
 |palavrasChaveOriginais | |String | |
 |palavrasChaveIngles | |String | |
 |quantidadePaginas | |Long | |
 |autores | |array[Autor] | |
 |volume | |Volume | |
        h3. Autor
        ||Field Name||Required||Type||Description||
         |id | |Long | |
 |ordem | |Long | |
 |email | |String | |
 |primeiroNome | |String | |
 |nomeDoMeio | |String | |
 |sobrenome | |String | |
 |afiliacao | |String | |
 |afiliacaoIngles | |String | |
 |nacao | |String | |
 |orcId | |String | |
 |artigo | |Artigo | |
        h3. Volume
        ||Field Name||Required||Type||Description||
         |id | |Long | |
 |edicao | |Long | |
 |sigla | |String | |
 |cidade | |String | |
 |dataInicio | |String | |
 |descricao | |String | |
 |artigos | |array[Artigo] | |
