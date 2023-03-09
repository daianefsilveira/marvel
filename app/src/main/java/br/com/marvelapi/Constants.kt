package br.com.marvelapi

import java.math.BigInteger
import java.security.MessageDigest
import java.sql.Timestamp


class Constants {

    companion object {
        const val BASE_URL = "http://gateway.marvel.com"
        val ts = Timestamp(System.currentTimeMillis()).time.toString()
        const val PUBLIC_KEY = "c76e528b5b5ea6d26e77d98911bfaf34"
        const val PRIVATE_KEY = "39e0013b9b030819dadacba7715123ef6b6cab3b"
        const val limit = "100"

        fun hash(): String {
            val input = "$ts$PRIVATE_KEY$PUBLIC_KEY"
            val md = MessageDigest.getInstance("MD5")
            return BigInteger(1, md.digest(input.toByteArray())).toString(16).padStart(32, '0')
        }
    }
}