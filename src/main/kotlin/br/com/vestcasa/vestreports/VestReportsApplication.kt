package br.com.vestcasa.vestreports

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableAsync

@EnableAsync
@SpringBootApplication
class VestReportsApplication

fun main(args: Array<String>) {
	runApplication<VestReportsApplication>(*args)
}
