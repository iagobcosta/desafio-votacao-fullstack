import { useState } from "react";
import { criarAgenda } from "../services/agendaService";
import { MainLayout } from "../layouts/MainLayout";
import { Container } from "../components/Container";

export function CreateAgendaPage() {
  const [title, setTitle] = useState("");
  const [description, setDescription] = useState("");

  const handleSubmit = async (e: React.FormEvent) => {
    e.preventDefault();

    await criarAgenda({
      title,
      description,
    });

    alert("Pauta criada com sucesso!");
    setTitle("");
    setDescription("");
  };

  return (
    <MainLayout>
      <Container>
        <h1 className="text-2xl font-bold mb-6">Criar nova pauta</h1>
        <form
          onSubmit={handleSubmit}
          className="bg-white p-8 rounded-2xl shadow-lg w-full max-w-md"
        >

        <input
          type="text"
          placeholder="Título da pauta"
          value={title}
          onChange={(e) => setTitle(e.target.value)}
          className="w-full mb-4 p-3 border rounded-lg"
        />

        <textarea
          placeholder="Descrição"
          value={description}
          onChange={(e) => setDescription(e.target.value)}
          className="w-full mb-4 p-3 border rounded-lg"
        />

        <button
          type="submit"
          className="w-full bg-blue-600 text-white p-3 rounded-lg font-semibold"
        >
          Criar pauta
        </button>
      </form>
    </Container>
  </MainLayout>
  );
}