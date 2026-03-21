import { BrowserRouter, Routes, Route } from "react-router-dom";
import { ListAgendasPage } from "../pages/ListAgendasPage";
import { CreateAgendaPage } from "../pages/CreateAgendaPage";

export function AppRoutes() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/pautas" element={<ListAgendasPage />} />
        <Route path="/pautas/nova" element={<CreateAgendaPage />} />
      </Routes>
    </BrowserRouter>
  );
}