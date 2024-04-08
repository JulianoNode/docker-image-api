'use client'

import React from "react";

interface FerstComponentProps{
    mensagem?: string;
    mensagemDoBotao: string;
}

export const FerstComponent: React.FC<FerstComponentProps> = (props: FerstComponentProps) =>{

    function handleClick(){
        console.log(props.mensagemDoBotao)
    }

    return (
        <div>
            { props.mensagem } <br />
            <button onClick={handleClick}>Clique aqui</button>
        </div>
    )
}

export const ArrowFunction = () => {
    return (
      <h2>Arrow Function </h2>
    )
}