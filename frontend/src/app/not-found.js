import Link from 'next/link'


export default function NotFound(){
    return(
        <div>
            <h2>Sitio no encontrado</h2>
            <p>Estamos trabajando en resolverlo! Mientras tanto...</p>
            <Link href='/'>Volver al Inicio</Link>
        </div>
    )
}