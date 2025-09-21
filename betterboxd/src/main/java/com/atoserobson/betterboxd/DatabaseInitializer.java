package com.atoserobson.betterboxd;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.atoserobson.betterboxd.controllers.dto.categoria.CategoriaRequest;
import com.atoserobson.betterboxd.controllers.dto.filme.FilmeRequest;
import com.atoserobson.betterboxd.services.CategoriaService;
import com.atoserobson.betterboxd.services.FilmeService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Configuration
public class DatabaseInitializer {

        private final CategoriaService categoriaService;
        private final FilmeService filmeService;

        @Bean
        CommandLineRunner popularH2() {
                return args -> {
                        log.info("Populando o banco H2...");

                        var categoriaRequest1 = new CategoriaRequest("Animação");
                        var categoria1 = categoriaService.criar(categoriaRequest1);

                        var filmeRequest1 = new FilmeRequest(
                                        "Como treinar seu dragão", "Um filme sobre dragões",
                                        "https://www.youtube.com/watch?v=HIbwgbbJzSs",
                                        categoria1.id());
                        filmeService.criar(filmeRequest1);

                        var categoriaRequest2 = new CategoriaRequest("Ação");
                        var categoria2 = categoriaService.criar(categoriaRequest2);

                        var categoriaRequest3 = new CategoriaRequest("Drama");
                        var categoria3 = categoriaService.criar(categoriaRequest3);

                        var filmeRequest2 = new FilmeRequest(
                                        "Vingadores: Ultimato",
                                        "Os heróis se unem para derrotar Thanos.",
                                        "https://www.youtube.com/watch?v=TcMBFSGVi1c",
                                        categoria2.id());
                        filmeService.criar(filmeRequest2);

                        var filmeRequest3 = new FilmeRequest(
                                        "A Origem",
                                        "Um ladrão que invade sonhos para roubar segredos.",
                                        "https://www.youtube.com/watch?v=YoHD9XEInc0",
                                        categoria3.id());
                        filmeService.criar(filmeRequest3);

                        var filmeRequest4 = new FilmeRequest(
                                        "Toy Story",
                                        "Brinquedos ganham vida quando os humanos não estão por perto.",
                                        "https://www.youtube.com/watch?v=KYz2wyBy3kc",
                                        categoria1.id());
                        filmeService.criar(filmeRequest4);

                        log.info("Populado com sucesso!");
                };
        }

}
