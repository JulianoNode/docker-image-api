'use client'
import { Template, ImageCard } from "@/components";

import { useState } from "react";


export default function GaleriaPage(){

    const image1 = "https://ggayane.github.io/css-experiments/cards/force_mage-character.webp"
    const image2 = "https://ggayane.github.io/css-experiments/cards/dark_rider-cover.jpg"

    const nome2 = 'Heroi Vermelho'
    const nome1 = 'Mago Azul '

    const [codigoImage, setCodigoImage] = useState<number>(2);
    const [urlImage, setUrlImage] = useState<String>(image2);
    const [nomeImage, setNomeImage] = useState<String>(nome2);

    function mudarImagem(){
        if (codigoImage == 1) {
            setCodigoImage(2);
            setUrlImage(image2)
            setNomeImage(nome2)
        } else {
            setCodigoImage(1);
            setUrlImage(image1)
            setNomeImage(nome1)
        }

    }

    return(
        <Template>
            <button className="bg-red-400" onClick={mudarImagem}>Click para mudar</button>
            <section className="grid grid-cols-5 gap-8">
                <ImageCard nome={nomeImage} tamanho="12MB" dataUpload="10/12/2001" src={urlImage} /> 
                <ImageCard nome={nomeImage} tamanho="12MB" dataUpload="10/12/2001" src={urlImage} />
                <ImageCard nome={nomeImage} tamanho="12MB" dataUpload="10/12/2001" src={urlImage} />             
            </section>            
        </Template>
        
    )
}

