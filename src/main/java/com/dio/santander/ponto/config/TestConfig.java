package com.dio.santander.ponto.config;

import com.dio.santander.ponto.model.*;
import com.dio.santander.ponto.model.pk.MovimentacaoPK;
import com.dio.santander.ponto.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
    @Autowired
    private BancoHorasRepository bancoHorasRepository;

    @Autowired
    private CalendarioRepository calendarioRepository;

    @Autowired
    private CategoriaUsuarioRepository categoriaUsuarioRepository;

    @Autowired
    private EmpresaRepository empresaRepository;

    @Autowired
    private JornadaRepository jornadaRepository;

    @Autowired
    private LocalidadeRepository localidadeRepository;

    @Autowired
    private MovimentacaoRepository movimentacaoRepository;

    @Autowired
    private NivelAcessoRepository nivelAcessoRepository;

    @Autowired
    private OcorrenciaRepository ocorrenciaRepository;

    @Autowired
    private TipoDataRepository tipoDataRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public void run(String... args) throws Exception {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

        // Categoria Usuário
        var cat1 = new CategoriaUsuario(null, "Funcionário");
        categoriaUsuarioRepository.save(cat1);

        // Jornada de Trabalho
        var jor1 = new JornadaTrabalho(null, "Jornada A");
        var jor2 = new JornadaTrabalho(null, "Jornada B");
        jornadaRepository.saveAll(Arrays.asList(jor1,jor2));

        // Empresa
        var e1 = new Empresa(null, "Profissional Sistemas de Informação Ltda", "59.272.900/0001-30", "Rua França 25", "Centro", "Chapecó", "SC", "(49) 3321-0000");
        empresaRepository.save(e1);

        // Nível acesso
        var n1 = new NivelAcesso(null, "Superior");
        nivelAcessoRepository.save(n1);

        // Localidade
        var l1 = new Localidade(null, "Central", n1);

        // Usuário
        var u1 = new Usuario(null, "Clemente", new BigDecimal("0.1"), LocalDateTime.parse("01-01-2021 08:00", formatter), LocalDateTime.parse("01-01-2021 18:00", formatter), cat1, e1, n1, jor1);
        usuarioRepository.save(u1);

        // Tipo Data
        var td1 = new TipoData(null, "Feriado Nacional");
        tipoDataRepository.save(td1);

        // Calendário
        var c1 = new Calendario(null, "Natal", LocalDateTime.parse("31-12-2021 00:00", formatter) , td1);
        var c2 = new Calendario(null, "Dia da Independência", LocalDateTime.parse("07-09-2021 00:00", formatter) , td1);
        calendarioRepository.saveAll(Arrays.asList(c1, c2));

        // Ocorrência
        var oc1 = new Ocorrencia(null, "Normal", "Ocorrência normal");
        var oc2 = new Ocorrencia(null, "Hora Extra", "Ocorrência de hora extra");
        ocorrenciaRepository.saveAll(Arrays.asList(oc1, oc2));

        // Movimentação
        var mid1 = new MovimentacaoPK(1, u1.getId());
        var m1 = new Movimentacao(mid1, LocalDateTime.parse("10-01-2021 08:00", formatter), LocalDateTime.parse("10-01-2021 12:00", formatter), new BigDecimal("4"), oc1, null);
        var mid2 = new MovimentacaoPK(2, u1.getId());
        var m2 = new Movimentacao(mid2, LocalDateTime.parse("10-01-2021 14:00", formatter), LocalDateTime.parse("10-01-2021 18:00", formatter), new BigDecimal("4"), oc1, null);
        var mid3 = new MovimentacaoPK(3, u1.getId());
        var m3 = new Movimentacao(mid3, LocalDateTime.parse(c2.getDataEspecial().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))+" 08:00", formatter)
                , LocalDateTime.parse(c2.getDataEspecial().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))+" 09:00", formatter), new BigDecimal("1"), oc2, c2);
        movimentacaoRepository.saveAll(Arrays.asList(m1, m2, m3));

        // Banco de horas


    }
}
