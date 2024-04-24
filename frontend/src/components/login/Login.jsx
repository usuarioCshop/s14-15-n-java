'use client'

import { Modal, ModalContent, ModalHeader, ModalBody } from '@nextui-org/react'
import { LoginForm } from './LoginForm'
import { userStore } from '@/store/userStore'
import { useEffect } from 'react'

export const Login = ({isOpen, onClose}) => {
    const { user } = userStore()
    
    useEffect(()=>{
        user.email ?
        onClose()
        : null
    },[user])


  return (
    <Modal
        size='sm'
        isOpen={isOpen}
        onClose={onClose}
        isKeyboardDismissDisabled={true}
        isDismissable={true}
        placement='top-center'
        className='bg-secondary-800/90 text-default-100 backdrop-blur-md py-5'>
            <ModalContent>
                {
                    (onClose) => (
                        <>
                            <ModalHeader className='flex flex-col gap-1 items-center mt-5'>
                                Inicia Sesión
                            </ModalHeader>
                            <ModalBody>
                                <LoginForm />
                            </ModalBody>
                            
                        </>
                    )
                }
            </ModalContent>

    </Modal>
  )
}
