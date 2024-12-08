# 📊 Consulta de Ações com API BRAPI e FeignClient  

Este projeto é uma aplicação desenvolvida para consultar os valores das ações de empresas em tempo real, utilizando a **API da BRAPI** e o **FeignClient** do Spring Boot. Foi projetada para ser simples, eficiente e segura, com configurações que seguem boas práticas de desenvolvimento.

---

## 🛠️ Funcionalidades  
- Conexão com a **API da BRAPI** para consultar informações de ações.  
- Retorno em tempo real de dados como preços atuais, variações percentuais, entre outros.  
- **Configuração de variáveis de ambiente** para proteger informações sensíveis como chaves de API.  
- Integração com **FeignClient**, simplificando a comunicação com a API e abstraindo requisições HTTP.  

---

## 💡 Destaques Técnicos  
1. **Uso do FeignClient:**  
   - Requisições HTTP abstratas e encapsuladas em interfaces Java.  
   - Código limpo e organizado, seguindo o padrão de injeção de dependências.  
   
2. **Configuração Segura:**  
   - Dados sensíveis, como URLs e tokens, armazenados em variáveis de ambiente.  
   - Proporciona maior segurança e flexibilidade na implantação em diferentes ambientes.

---

## 🌟 Como Executar  
1. Clone o repositório:  
   ```bash
   git clone https://github.com/seu-usuario/consulta-acoes-brapi.git

2. Faça login no site https://brapi.dev/, acesse a tela de Dashboard, gere um token e configure ele nas suas variáveis de ambiente com o nome TOKEN. 

## 📈 Próximos Passos  

- Adicionar novas métricas financeiras.  
- Melhorar o design e a usabilidade com integração frontend.  
- Implementar testes automatizados para garantir maior confiabilidade.  

Explore e contribua para o projeto! 😊  
