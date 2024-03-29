package com.mycompany.myapp.utils

import tornadofx.*

class BaseController : Controller() {
    val api: Rest by inject()
    var ENDPOINT= "http://localhost:8080"
    var BASE_URI= "/api/"



    init {
        api.baseURI = ENDPOINT

        //Authentication Basic Auth
       // api.setBasicAuth("username", "password")

        //Authentication using Header
        /*val requestInterceptor = { request ->
            val b64 = Base64.getEncoder().encodeToString("username:password".toByteArray(UTF_8))
            request.addHeader("Authorization", "Basic $b64")
        }*/

        //Intercepting calls
        //You can for example show a login screen if an HTTP call fails with statusCode 401
        /*api.engine.responseInterceptor = { response ->
            if (response.statusCode == 401)
                //....
        }*/

        //Basic operations
        //fun loadCustomers() = api.get("customers").list().toModel<Customer>()
        //fun loadCustomers(): ObservableList<Customer> = api.get("customers").list().toModel()

        //This is what happens when you call Rest.useApacheHttpClient
        //Rest.engineProvider = { api -> HttpClientEngine(api) }

        //A proxy can be configured either by implementing an interceptor that augments each call, or, preferably once per Rest client instance:
        //api.proxy = Proxy(Proxy.Type.HTTP, InetSocketAddress("127.0.0.1", 8080))

        //Setting timeouts
        api.engine.requestInterceptor = {
            (it as HttpURLRequest).connection.readTimeout = 5000
        }
    }

    companion object {
        val TOKEN = "idtoken"
    }

    fun setToken(token: String){
        with(config){
            set(TOKEN to token)
            api.engine.requestInterceptor ={ request ->
                request.addHeader("Authorization", "Bearer $token")
            }
            save()
        }
    }

    fun getToken():String{
        return config.getProperty(TOKEN).toString()
    }

    //The following example updates a customer object.
    //fun updateCustomer(customer: Customer) = api.put("customers/${customer.id}", customer)

    //If the api endpoint returns the customer object to us after save, we would fetch a JsonObject by calling one() and then toModel() to convert it back into our model object.
   // fun updateCustomer(customer: Customer) = api.put("customers/${customer.id}", customer).one().toModel<Customer>()


    //Query parameters needs to be URL encoded. The Map.queryString extension value will turn any map into a properly URL encoded query string:
    //val params = mapOf("id" to 1)
    //api.put("customers${params.queryString}", customer).one().toModel<Customer>()

    //Error Handling
    /*fun getCustomer(id: Int): Customer {
        val response = api.get("some/action")

        try {
            if (response.ok())
                return response.one().toModel()
            else if (response.statusCode == 404)
                throw CustomerNotFound()
            else
                throw MyException("getCustomer returned ${response.statusCode} ${response.reason}")
        } finally {
            response.consume()
        }
    }*/
}
