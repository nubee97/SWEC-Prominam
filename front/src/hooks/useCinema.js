import { useContext } from "react";
import AppStateContext from "../contexts/AppStateContext";

export default function useCinema() {
  const { cinema } = useContext(AppStateContext);

  return cinema;
}
