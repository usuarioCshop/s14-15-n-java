import { Inter } from 'next/font/google';
import './globals.css';
import { Providers } from './Providers';
import { Footer, Header } from '@/components';

const inter = Inter({ subsets: ['latin'] });

export const metadata = {
  title: 'ClassLodge',
  description: 'Adquirí nuevas habilidades sin salir de tu casa',
};

export default function RootLayout({ children }) {
  return (
    <html lang="en" className='bg-[#180828]'>
      <body className={`${inter.className}`}>
        <Providers>
          <Header />
          <main className='max-w-6xl mx-auto'>
            {children}
          </main>
          <Footer />
        </Providers>
      </body>
    </html>
  );
}
