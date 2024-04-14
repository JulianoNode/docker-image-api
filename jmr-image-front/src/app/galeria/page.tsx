'use client'
import { Template, ImageCard } from "@/components";
import { Image } from "@/resources/image/image.resource";
import { useImageService } from '@/resources/image/image.service';
import { useState } from "react";

export default function GaleriaPage(){

    const useService = useImageService();

    const [images, setImages] = useState<Image[]>([])


    async function searchImages(){
        const result = await useService.buscar();
        setImages(result);
        console.table(result)
    }

    return(
        <Template>
            <button className="bg-red-400" onClick={searchImages}>Click para mudar</button>
            <section className="grid grid-cols-5 gap-8">
                <ImageCard nome="{nomeImage}" tamanho="12MB" dataUpload="10/12/2001" src="" /> 
            
            </section>            
        </Template>       
    )

}

