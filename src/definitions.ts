export interface nfcreaderPlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
}
