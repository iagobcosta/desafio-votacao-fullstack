import { api } from "./api";

export interface CriarAgendaRequest {
  title: string;
  description: string;
}

export const criarAgenda = async (data: CriarAgendaRequest) => {
  const response = await api.post("/agenda", data);
  return response.data;
};