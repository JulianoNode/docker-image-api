import { FerstComponent, ArrowFunction } from '../componentsTest/FerstComponents'

export default function Home() {
  return (
    <div>
      <FerstComponent mensagem='1) Olá, está mensagem é com REACT' 
                      mensagemDoBotao='Está é a mensagem do botão'/>

      <FerstComponent mensagem='2) Olá, Segundo componente com REACT' 
                      mensagemDoBotao='Cliqui e Salve!!!'/>

    <FerstComponent   mensagemDoBotao='3) Mensagem Opcional com o interrogação mensagem?'/>
      
      <ArrowFunction/>
    </div>
  )
}

