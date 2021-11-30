import { useContext } from "react";
import AppStateContext from "../contexts/AppStateContext";

export default function useSeat() {
  const { seat } = useContext(AppStateContext);

  return seat;
}
