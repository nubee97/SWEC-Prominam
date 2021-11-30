import { useContext } from "react";
import AppStateContext from "../contexts/AppStateContext";

export default function useConfirm() {
    const { confirm } = useContext(AppStateContext);

    return confirm;
}