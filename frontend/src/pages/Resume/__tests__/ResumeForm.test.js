import { render, screen, fireEvent } from '@testing-library/react';
import { MemoryRouter } from 'react-router-dom';
import ResumeForm from '../ResumeForm';

describe('ResumeForm', () => {
  const mockData = {
    name: 'John Doe',
    age: 30,
    skills: ['JavaScript', 'React'],
    experience: '5 years of experience in software development',
  };

  it('should render the form with pre-filled data', () => {
    render(
      <MemoryRouter initialEntries={[{ state: { data: mockData } }]}>
        <ResumeForm />
      </MemoryRouter>
    );

    expect(screen.getByDisplayValue('John Doe')).toBeInTheDocument();
    expect(screen.getByDisplayValue('30')).toBeInTheDocument();
    expect(screen.getByDisplayValue('JavaScript, React')).toBeInTheDocument();
    expect(screen.getByDisplayValue('5 years of experience in software development')).toBeInTheDocument();
  });

  it('should allow user to edit the form fields', () => {
    render(
      <MemoryRouter initialEntries={[{ state: { data: mockData } }]}>
        <ResumeForm />
      </MemoryRouter>
    );

    const nameInput = screen.getByLabelText(/姓名/i);
    fireEvent.change(nameInput, { target: { value: 'Jane Doe' } });

    expect(nameInput.value).toBe('Jane Doe');
  });
});