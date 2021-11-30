import { useContext } from "react";
import AppStateContext from "../contexts/AppStateContext";

export default function useLogin() {
    const { login } = useContext(AppStateContext);

    return login;
}