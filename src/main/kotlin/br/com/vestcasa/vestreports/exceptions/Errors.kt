package br.com.vestcasa.vestreports.exceptions

enum class Errors(val message: String) {
    NF("not found"),
    FB("user forbidden"),
    EXP("expired")
}