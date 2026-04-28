package org.example.backend.controllers

interface Controllers {
    val auth get() = AuthController()
    val user get() = UserController()
}