# eclipse
Projeto de PS

Projeto usa bloco de notas (dentro do rar nova pasta), logo precisa deles definidos, uma string na classe Inicio, no pacote geral, define o endereço da pasta.

Os blocos de notas já com nomes certos no programa se encontra no arquivo WinRar

Padrões utilizados:
  Memento: Utilizado para fazer Undo/Rendo em alguns pontos do programa, tais como ponto, cadastro de funcionários, remoção, mudança de taxas de todos funcionários, vendas, etc. Com ele implementar a função de undo/rendo ficou bastante simples, e não custou muitas linhas de programação.
  Strategy: Utilizei para exportar folhas de pagamentos e gerar uma tabela dentro do próprio programa com informações válidas de quem está sendo pago de fato, que ajudou a organizar o projeto, custando apenas a criação de algumas classes a mais, mas ainda sim bastante útil, pois estas informações tem muitos cálculos e exigências de dados e diminuir a quantidade de funções juntas ajuda a organizar esta parte do programa.
