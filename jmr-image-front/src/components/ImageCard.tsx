export const ImageCard: React.FC = () => {


    return (
        <div className="card relative bg-white rounded-md shadow-md transition-tranform 
                        ease-in duration-300 transform hover:shadow-lg hover:-translate-y-2">
           <img src="https://ggayane.github.io/css-experiments/cards/dark_rider-cover.jpg" className="h-56 w-full object-cover rounded-t-md" alt="" />
           <div className="card-body p-4">
                <h5 className="text-xl font-semibold mb-2 text-gray-600">Nome da Imagem</h5>
                <p className="text-gray-600">Tamanho</p>
                <p className="text-gray-600">Data Upload</p>
               
            </div>

            <img src="https://ggayane.github.io/css-experiments/cards/force_mage-cover.jpg" className="h-56 w-full object-cover rounded-t-md" alt="" />
           <div className="card-body p-4">
                <h5 className="text-xl font-semibold mb-2 text-gray-600">Nome da Imagem</h5>
                <p className="text-gray-600">Tamanho</p>
                <p className="text-gray-600">Data Upload</p>
               
            </div>
        </div>
    )
}