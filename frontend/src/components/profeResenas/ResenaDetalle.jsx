import React from "react";
import {
  Modal,
  ModalContent,
  ModalHeader,
  ModalBody,
  ModalFooter,
  Button,
  useDisclosure,
} from "@nextui-org/react";
import {
  Table,
  TableHeader,
  TableColumn,
  TableBody,
  TableRow,
  TableCell,
} from "@nextui-org/react";


export default function ResenaDetalle({ comentarios }) {
  const { isOpen, onOpen, onOpenChange } = useDisclosure();

  console.log("lista de comentarios en modal", comentarios);

  return (
    <>
      <Button className="bg-default-700 text-default-50" onPress={onOpen}>
        Comentarios
      </Button>
      <Modal className="bg-default-400" isOpen={isOpen} onOpenChange={onOpenChange}>
        <ModalContent >
          {(onClose) => (
            <>
              <ModalHeader className="flex flex-col gap-1">
                Comentarios
              </ModalHeader>
              <ModalBody >
                <Table aria-label="Example static collection table" id="hola">
                  <TableHeader>
                    <TableColumn className="bg-default-400">Usuario</TableColumn>
                    <TableColumn  className="bg-default-400">Comentario</TableColumn>
                    <TableColumn  className="bg-default-400">Rating</TableColumn>
                  </TableHeader>
                  <TableBody >
                    {comentarios.map((comment) => (
                      <TableRow key={comment.id}>
                        <TableCell>{comment.userName}</TableCell>
                        <TableCell>{comment.comment}</TableCell>
                        <TableCell>{comment.rating}</TableCell>
                      </TableRow>                      
                    ))}
  
                  </TableBody>
                </Table>
              </ModalBody>
              <ModalFooter>
                <Button color="danger" variant="light" onPress={onClose}>
                  Close
                </Button>
              </ModalFooter>
            </>
          )}
        </ModalContent>
      </Modal>
    </>
  );
}
