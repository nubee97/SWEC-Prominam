import { useContext } from "react";
import AppStateContext from "../contexts/AppStateContext";

export default function useTickets() {
  const { ticket } = useContext(AppStateContext);

  return ticket;
}
