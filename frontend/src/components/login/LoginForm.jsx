import { useLogin } from '@/hook/useLogin';
import { Input, Button } from '@nextui-org/react'

export const LoginForm = () => {
  const { setUserData, userData, error, handleLogin} = useLogin()
  
  const handleChange = (e) => {
    setUserData({
      ...userData,
      [e.target.name]:e.target.value
    })
  }
  return (
    <form className="flex flex-col items-center justify-between gap-5"
      onSubmit={handleLogin}>
        {
          error && <p className='text-center p-5 rounded-md bg-secondary-300/95 text-white'>Todos los campos son obligatorios</p>
        }
      <Input
        className="p-5 bg-transparent text-default-50"
        color="warning"
        placeholder="tuemail@email.com"
        variant="underlined"
        value={userData.emailUser}
        type="email"
        onChange={handleChange}
        name="emailUser"
        id="emailUser"
      />
      <Input
        className="p-5 bg-transparent"
        color="warning"
        placeholder="********"
        variant="underlined"
        onChange={handleChange}
        value={userData.password}
        type="password"
        name="password"
        id="password"
      />
      <div className="w-full flex place-content-center">
        <Button
          type="submit"
          variant="flat"
          className="text-default-50 bg-secondary-400 w-3/5 mx-auto rounded-none font-semibold"
        >
          Ingresar
        </Button>
      </div>
    </form>
  );
};
