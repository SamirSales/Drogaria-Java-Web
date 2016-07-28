-- phpMyAdmin SQL Dump
-- version 4.0.10deb1
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tempo de Geração: 28/07/2016 às 18:30
-- Versão do servidor: 5.5.50-0ubuntu0.14.04.1
-- Versão do PHP: 5.5.9-1ubuntu4.17

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Banco de dados: `drogaria`
--

-- --------------------------------------------------------

--
-- Estrutura para tabela `fabricante`
--

CREATE TABLE IF NOT EXISTS `fabricante` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(50) NOT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=18 ;

--
-- Fazendo dump de dados para tabela `fabricante`
--

INSERT INTO `fabricante` (`codigo`, `descricao`) VALUES
(1, 'Laboratório Gross'),
(2, 'Laboratório Industrial Farmacêutico Lifar '),
(3, 'Laboratório Madrevita'),
(4, 'Laboratório Melpoejo'),
(5, 'Laboratório Rocha '),
(6, 'Laboratório Simões'),
(7, 'Laboratório Teuto Brasileiro '),
(8, 'Laboratório Zurita '),
(9, 'Laboratórios Britania'),
(10, 'Laboratórios Farmacêuticos Sten-Kal '),
(11, 'Exemplo 1'),
(12, 'Exemplo 2'),
(13, 'Exemplo 3'),
(14, 'Exemplo 4'),
(15, 'Exemplo 5'),
(17, 'Exemplo 6');

-- --------------------------------------------------------

--
-- Estrutura para tabela `produto`
--

CREATE TABLE IF NOT EXISTS `produto` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(50) NOT NULL,
  `quantidade` int(11) NOT NULL,
  `preco` double NOT NULL,
  `codigo_fabricante` int(11) NOT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=11 ;

--
-- Fazendo dump de dados para tabela `produto`
--

INSERT INTO `produto` (`codigo`, `descricao`, `quantidade`, `preco`, `codigo_fabricante`) VALUES
(1, 'novalgina com 10 comprimidos', 32, 5.5, 1),
(2, 'teste', 0, 0, 0),
(5, 'teste 3', 1189, 1.99, 5),
(6, 'teste 4', 7, 1.3, 4),
(7, 'teste 5', 257, 1.58, 10),
(8, 'Produto ABC', 16, 32.45, 3),
(9, 'ABC', 2, 12.346, 1),
(10, 'DEF', 12, 7.33, 8);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
