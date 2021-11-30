import { useContext } from "react";
import AppStateContext from "../contexts/AppStateContext";

export default function useDateSchedule() {
  const { dateSchedule } = useContext(AppStateContext);

  return dateSchedule;
}
