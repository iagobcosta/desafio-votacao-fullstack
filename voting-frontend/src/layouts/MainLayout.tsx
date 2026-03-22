import { type ReactNode } from "react";
import { Link } from "react-router-dom";

interface MainLayoutProps {
  children: ReactNode;
}

export function MainLayout({ children }: MainLayoutProps) {
  return (
    <div className="min-h-screen bg-gray-100">
      <header className="bg-white shadow-sm">
        <div className="max-w-6xl mx-auto px-6 py-4 flex justify-between">
          <h1 className="text-xl font-bold text-blue-600">
            Voting System
          </h1>

          <nav className="flex gap-6 text-gray-600">
            <Link to="/pautas">Pautas</Link>
            <Link to="/pautas/nova">Nova pauta</Link>
          </nav>
        </div>
      </header>

      <main className="max-w-6xl mx-auto px-6 py-8">
        {children}
      </main>
    </div>
  );
}